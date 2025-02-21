package com.books.book03.net.mindview.util;
//: net/mindview/util/ProcessFiles.java

import java.io.File;
import java.io.IOException;

public class ProcessFiles {
  private Strategy strategy;
  private String ext;

  public ProcessFiles(Strategy strategy, String ext) {
    this.strategy = strategy;
    this.ext = ext;
  }

  // Demonstration of how to use it:
  public static void main(String[] args) {
    new ProcessFiles(new ProcessFiles.Strategy() {
      public void process(File file) {
        System.out.println(file);
      }
    }, "java").start(args);
  }

  public void start(String[] args) {
    try {
      if (args.length == 0)
        processDirectoryTree(new File("."));
      else
        for (String arg : args) {
          File fileArg = new File(arg);
          if (fileArg.isDirectory())
            processDirectoryTree(fileArg);
          else {
            // Allow user to leave off extension:
            if (!arg.endsWith("." + ext))
              arg += "." + ext;
            strategy.process(
                new File(arg).getCanonicalFile());
          }
        }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void
  processDirectoryTree(File root) throws IOException {
    for (File file : Directory.walk(
        root.getAbsolutePath(), ".*\\." + ext))
      strategy.process(file.getCanonicalFile());
  }

  public interface Strategy {
    void process(File file);
  }
} /* (Execute to see output) *///:~
