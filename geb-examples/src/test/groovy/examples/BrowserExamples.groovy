package examples

import geb.Browser

Browser.drive {
    go "signup"
    assert $("h1").text() == "Signup Page"
}

Browser.drive {
    go()
    go "signup"
    go "signup", param1: "value1", param2: "value2"
}

Browser.drive {
    go()
    $("a").click()
    withWindow({ title == "Geb - Very Groovy Browser Automation" }) {
        assert $(".slogan").text().startsWith("Very Groovy browser automation.")
    }
}




