package com.algocrafts.development;

import java.io.File;
import java.util.List;

public interface VersionControl {
    void checkin(List<File> files) throws InvalidPasswordException, FileChangedException;
}
