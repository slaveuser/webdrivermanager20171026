/*
 * (C) Copyright 2016 Boni Garcia (http://bonigarcia.github.io/)
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 */
package io.github.bonigarcia.wdm.base;

import static java.util.concurrent.TimeUnit.SECONDS;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Parent class for browser based tests.
 *
 * @author Boni Garcia (boni.gg@gmail.com)
 * @since 1.4.1
 */
public abstract class BaseBrowserTst {

    protected static final int TIMEOUT = 30; // seconds

    protected static boolean validOS = true;

    protected WebDriver driver;

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test() {
        if (validOS) {
            driver.manage().timeouts().implicitlyWait(TIMEOUT, SECONDS);
            driver.get("https://en.wikipedia.org/wiki/Main_Page");
            driver.findElement(By.id("searchInput")).sendKeys("Software");
            driver.findElement(By.id("searchButton")).click();
        }
    }

    @AfterClass
    public static void teardownClass() {
        validOS = true;
    }
}
