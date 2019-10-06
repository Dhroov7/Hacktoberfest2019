# This is a basic 3-line code that uses Selenium module to open the Github website. It also needs geckodriver installed tho.

from selenium import webdriver
browser = webdriver.Firefox()
browser.get('www.github.com')