package com.khepri.black.filesystem.file;

import java.io.IOException;

public interface IFileHandler {
    Object getFileContent(String path) throws IOException;
}
