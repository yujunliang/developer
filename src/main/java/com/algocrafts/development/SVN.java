package com.algocrafts.development;

import java.io.File;
import java.util.List;

public interface SVN {
    void checkin(List<File> files) throws InvalidPasswordException, FileChangedException;
}
