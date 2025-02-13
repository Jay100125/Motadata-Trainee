# Charcter encoding

- first any charcter is converted into hexadecimal number then that hexa decimal number is translated into binary
- Big Endian :- MSB stored at lowest Memory address
- Low Endian :- MSB stored at highest memory address

- stream is connection between java program and source
- input stream & output stream
  - open stream
  - read/write
  - close stream
- two types of stream
  - byte stream
  - charcter stream

### inputStream
- base abstract class for all byte input streams
- abstract int read() throws IOException

### ouptutStream
- abstract void write() throws IOException

- Buffering
- read/write block of bytes into memory buffer
- buffer ~ byte array
- default buffer size ~ 8192 bytes
- doesn't exist alone


- file instance represents a path, not file contents
- 