package de.pifrasso.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class FileCopy {

    private static PathMatcher jarmatcher = FileSystems.getDefault().getPathMatcher("glob:*.jar");

    public static void main(String[] args) {


        Path path = Paths.get("/Users/kadeem/.m2/repository/de/sky-eye/dispolino/rail-fahrzeug");
        final List<Path> files = new ArrayList<>();
        try {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (!attrs.isDirectory()) {
                        if (jarmatcher.matches(file)) {
                            files.add(file);
                        }
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Path entry: files)
        {
            System.out.println(entry.toString());
        }

    }
}
