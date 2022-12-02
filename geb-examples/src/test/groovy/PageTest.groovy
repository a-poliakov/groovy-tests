import geb.Browser

Browser.drive {
    to GebHomePage

    manualsMenu.open()

    manualsMenu.links[0].click()

    at TheBookOfGebPage
}
