package com.diogosantos.core;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by diogo on 12/06/15.
 */
public class FileDirectoryStrategyTest {

    FileDirectoryStrategy fileDirectoryStrategy = new FileDirectoryStrategy();

    @Test
    public void testGetPath() throws Exception {

        assertEquals("~/thumbnail/abcd/efhi/abcdefhij.jpg",
                fileDirectoryStrategy.getPath(NamedSize.THUMBNAIL, "abcdefhij.jpg"));

        assertEquals("~/original/abcd/efhi/abcdefhij.jpg",
                fileDirectoryStrategy.getPath(NamedSize.ORIGINAL, "abcdefhij.jpg"));

        assertEquals("~/thumbnail/abc.jpg",
                fileDirectoryStrategy.getPath(NamedSize.THUMBNAIL, "abc.jpg"));

        assertEquals("~/thumbnail/abcd/abcde.jpg",
                fileDirectoryStrategy.getPath(NamedSize.THUMBNAIL, "abcde.jpg"));
    }
}