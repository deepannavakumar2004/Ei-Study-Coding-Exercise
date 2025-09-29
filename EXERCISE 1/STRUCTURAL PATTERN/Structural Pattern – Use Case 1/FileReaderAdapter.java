public class FileReaderAdapter implements FileReaderInterface {
    private final LegacyFileReader legacyReader;

    public FileReaderAdapter(LegacyFileReader legacyReader) {
        this.legacyReader = legacyReader;
    }

    @Override
    public String readFile(String path) {
        return legacyReader.readLegacyFile(path);
    }
}
