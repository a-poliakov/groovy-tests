package examples

import geb.Browser
import geb.Page


Browser.drive {
    to PageWithDiv

    // Following two lines are equivalent
    assert page.theDiv.text() == "a"
    assert page.theDiv().text() == "a"
}

Browser.drive {
    to PageWithDiv
    assert page.theDiv.text() == "a"
}

def content = {
    loginButton(to: [LoginSuccessfulPage, LoginFailedPage]) { $("input.loginButton") }
}

class DynamicPageWithWaiting extends Page {
    static content = {
        dynamicallyAdded(wait: true) { $("p.dynamic") }
    }
}
class PageWithFrame extends Page {
    static content = {
        myFrame(page: FrameDescribingPage) { $('#frame-id') }
    }
}

class FrameDescribingPage extends Page {
    static content = {
        frameContentsText { $('span').text() }
    }
}
