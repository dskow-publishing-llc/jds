//Copyright 2015 Securboration Inc.
package com.dskow.downloader.test;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dskow.downloader.service.jds.DownloaderController;
import com.dskow.downloader.service.jds.JournalDocDownloaderService;

import junit.framework.TestCase;

public class DownloaderTest extends TestCase
{
  /**
   * The Logger for DownloaderTest. The LOG is not for serialization.
   */
  private static final transient Logger LOG = LoggerFactory
          .getLogger(DownloaderTest.class);
  
  public DownloaderTest(String name)
  {
    super(name);
  }

  /**
   * The method under test specifies that it can throw IOException, which is a
   * checked exception. Therefore, the unit test won't compile unless you catch
   * the exception or declare that the test method can propagate the exception.
   * The second alternative is preferred because it results in shorter and more
   * focused tests:
   * 
   * Do this instead
   * 
   * @Test public void foo_seven() throws Exception
   * {
   *   assertEquals(3, new Foo().foo(7));
   * }
   * 
   * A method that accepts an integer and returns an integer and throws an
   * IOException if it encounters an error.  Instead of manually catching the
   * expected exception, use the expected attribute on JUnit's @Test annotation.
   * 
   * Do this instead
   * @Test(expected = IOException.class)
   * public void foo_nine() throws Exception
   * {
   *   new Foo().foo(9);
   * }
   */
	private DownloaderController downloader;

  private JournalDocDownloaderService journalDocDownloaderService;
  
  @Before
  public void setup()
  {
  }

  @Test
  public void testDownloader() throws Exception
  {
    LOG.debug("testing DownloaderController");
    journalDocDownloaderService = new JournalDocDownloaderService();
    downloader = new DownloaderController(journalDocDownloaderService);
  }
  
  @Test
  public void testDOMBuilder() throws Exception
  {
    LOG.debug("testing DOMBuilder");
    journalDocDownloaderService = new JournalDocDownloaderService();
    downloader = new DownloaderController(journalDocDownloaderService);
  }
  
}