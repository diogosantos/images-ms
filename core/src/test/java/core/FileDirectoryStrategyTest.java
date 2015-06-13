package core;

import core.data.FileDirectoryStrategy;
import core.model.NamedSize;
import org.junit.Assert;
import org.junit.Test;

public class FileDirectoryStrategyTest {

    FileDirectoryStrategy fileDirectoryStrategy = new FileDirectoryStrategy();

    @Test
    public void testGetPath() throws Exception {

        Assert.assertEquals("thumbnail/abcd/efhi/abcdefhij.jpg",
                fileDirectoryStrategy.getPath(NamedSize.THUMBNAIL, "abcdefhij.jpg"));

        Assert.assertEquals("original/abcd/efhi/abcdefhij.jpg",
                fileDirectoryStrategy.getPath(NamedSize.ORIGINAL, "abcdefhij.jpg"));

        Assert.assertEquals("thumbnail/abc.jpg",
                fileDirectoryStrategy.getPath(NamedSize.THUMBNAIL, "abc.jpg"));

        Assert.assertEquals("thumbnail/abcd/abcde.jpg",
                fileDirectoryStrategy.getPath(NamedSize.THUMBNAIL, "abcde.jpg"));
    }
}