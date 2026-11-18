# CSC320MOD7 – Linked Lists, ArrayLists and Streams

Java practice programs for singly linked lists built from node classes, sorted insertion in a linked list versus an `ArrayList`, string parsing, and `printf`/stream formatting.

## Overview

This is **CSU Global CSC320 (Programming I), Module 7** practice work, committed as "Chapter 7" zyLabs-style exercises. It is an Eclipse project (`src/` is the source folder). Programs with several classes are grouped into packages (`Inventory`, `LibraryBookSorting`, `MileageTracker`, `PlaylistLab20`, `PlaylistLinkedList`). Single-file programs are in the default package. `Books.txt` in the repository root is the data file that `LibraryBookSorting.Library` reads.

## Linked-list programs

All of these use the same pattern: a **node class** holds data plus a reference to the next node (`nextNodeRef`/`nextNodePtr`), and `insertAfter(node)` splices a node in with the classic three steps (save `next`, point this at the new node, point the new node at the saved `next`). Most of them start the list with a **dummy head node**.

| Package / file | What it does |
|---|---|
| `ContactList.java` + `ContactNode.java` | Reads 3 name/phone pairs, appends each to the tail of a linked list (it tracks both `head` and `tail`), then walks the list and prints `CONTACT LIST`. |
| `Inventory/Inventory.java` + `InventoryNode.java` | Reads *n* `item quantity` pairs and calls `insertAtFront(headNode, newNode)`, so the list prints in **reverse input order**. For example, `3 / shoes 2 / hats 5 / socks 4` → `4 socks`, `5 hats`, `2 shoes`. |
| `MileageTracker/MileageTrackerLinkedList.java` + `MileageTrackerNode.java` | Reads *n* `miles date` entries, appends each after the last node, and prints `miles, date` for each. |
| `PlaylistLab20/Playlist.java` + `SongNode.java` | Reads songs (title, length, artist) until `-1`, appends them, and prints `LIST OF SONGS` through `printPlaylist(headNode)`. |
| `PlaylistLinkedList/Playlist.java` + `SongEntry.java` | A **menu-driven playlist manager** (described below). |

### `PlaylistLinkedList` – playlist manager
`SongEntry` stores a unique ID, song name, artist, length in seconds and a `nextNode` reference, with getters, `setNext`, `insertAfter` and `printPlaylistSongs`. `Playlist.main` asks for a playlist title and then loops over a menu:

| Option | Method | Behaviour |
|---|---|---|
| `a` | `addSong` | Reads ID, name, artist and length, and appends the song at the tail |
| `d` | `removeSong` | Finds a song by ID with a `prev`/`curr` walk and unlinks it, handling the head, middle and tail cases |
| `c` | `changePosition` | Moves a song from its current position to a new one (the new position is clamped to 1…size), updating `head`/`tail` as needed |
| `s` | `outputSongsByArtist` | Lists the songs whose artist matches, ignoring case, with their positions |
| `t` | `outputTotalTime` | Adds up the song lengths |
| `o` | `outputFullPlaylist` | Prints every song with its position |
| `q` | – | Quits |

Because Java methods can't return two values, each method that changes the list returns the updated head and tail together as a `SongEntry[]{head, tail}`.

### `LibraryBookSorting` – linked list vs. ArrayList insertion cost
- `Book` (title, author, ISBN) is the element type stored in an `ArrayList`. `BookNode` is the equivalent linked-list node.
- `LinkedListLibrary.insertSorted(BookNode, counter)` walks the list to the node before the insertion point and splices the new node in. It counts **1 operation** per insert.
- `ArrayListLibrary.insertSorted(Book, counter)` appends a `null` slot, then shifts larger-ISBN books down one slot at a time, counting each shift plus the final placement. This is the cost of insertion-sort-style insertion into an array.
- `Library.main` loads `Books.txt` (title / ISBN / author on three lines per book, 5 books here) into both structures. It then reads one new book from standard input, inserts it into both, and prints how many operations each structure needed.

Sample (verified, run from the repository root so that `Books.txt` is found):
```
$ printf 'Dune\n9780441172719\nFrank Herbert\n' | java -cp bin LibraryBookSorting.Library
Number of linked list operations: 1
Number of ArrayList operations: 5
```

## String parsing and formatting programs

| File | What it does |
|---|---|
| `DataVisualizer.java` | Reads a title, two column headers and `string, int` data points until `-1`. It validates each data point (no comma, too many commas, or no integer after the comma) and stores the pieces in two `ArrayList`s. It then prints a right-aligned table (`%-20s|%23d`) and a `*` histogram. |
| `DateParser.java` | Reads dates like `March 1, 2018` until `-1`. It splits them with `indexOf`/`substring`, converts the month name with a `switch` in `getMonthAsInt`, and prints `3/1/2018`. Malformed lines are skipped quietly. |
| `ParseStrings.java` | Reads `word, word` strings until `q`. It checks for a comma with `hasComma()`, splits on `\\s*,\\s*`, and prints the first and second word. |
| `FormatDemo.java` | A tour of `printf` flags (`-`, `+`, space, `0`), width and precision, `%o/%x/%X/%e/%c/%%`, and `System.out.flush()`. |
| `ReportExample.java` | Reads `item price` pairs until `done`, writes a formatted shopping-list report to a `PrintWriter` backed by a `StringWriter`, and then prints the finished string. |
| `StringInputStream.java` | Parses `Jan 12 1992` from a single line by wrapping it in a second `Scanner`. |
| `StringOutputStream.java` | Builds output (`Headphones x12`, `25% off`) in a `StringWriter`/`PrintWriter` before printing it. |
| `InputStreamReader.java` | Reads raw bytes with `System.in.read()` to show byte-level input. Note that its class name shadows `java.io.InputStreamReader`. |

## Build and run

JDK 11 or newer (the code uses `String.strip()`). From the repository root:

```bash
mkdir -p bin
javac -d bin src/*.java src/*/*.java
java -cp bin PlaylistLinkedList.Playlist
java -cp bin LibraryBookSorting.Library   # run from the repo root so Books.txt is found
java -cp bin DateParser
```

Because the default-package classes and the packaged classes are in separate namespaces, the two `Playlist` classes don't clash.

## Concepts demonstrated
- Singly linked lists: node classes, dummy head nodes, head/tail references, insert at front, append at tail, unlink (remove), and move
- Comparing insertion cost in a linked list and an `ArrayList`
- Reading structured data from a text file with `FileInputStream` + `Scanner`
- String parsing with `split`, `indexOf`, `substring` and string-backed `Scanner`s
- `ArrayList<String>`/`ArrayList<Integer>` as dynamic parallel lists
- Formatted output with `printf`, and in-memory output with `StringWriter`/`PrintWriter`
