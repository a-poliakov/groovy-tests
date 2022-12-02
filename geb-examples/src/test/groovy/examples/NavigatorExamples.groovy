package examples

import geb.Browser
import geb.navigator.Navigator
import geb.navigator.event.NavigatorEventListenerSupport
import org.openqa.selenium.Keys

navigatorEventListener = new NavigatorEventListenerSupport() {
    void afterClick(Browser browser, Navigator navigator) {
        println "${navigator*.tag()} was clicked"
    }
}
Browser.drive {
    assert $($("p.a"), $("p.b"))*.text() == ["1", "2"]
}

Browser.drive {
    assert $("p.a").add("p.b").add(By.className("c"))*.text() == ["1", "2", "3"]
}

Browser.drive {
    $("a.login").click(LoginPage)

    $(name: "description").click()

    assert focused().attr("name") == "description"
    assert $(name: "description").focused

    $("input") << "foo"
    assert $("input").value() == "foo"

    $("input") << Keys.chord(Keys.CONTROL, "c")

    $("form").pet = true

    $("form").pet = ["dog", "lizard"]
    $("form").pet = ["Canis familiaris", "Lacerta"]

    $("form").csvFile = uploadedFile.absolutePath
}

Browser.drive {
    interact {
        keyDown Keys.SHIFT
        click $("li.clicky")
        keyUp Keys.SHIFT
    }

    interact {
        clickAndHold($('#draggable'))
        moveByOffset(150, 200)
        release()
    }

    interact {
        dragAndDropBy($("#draggable"), 150, 200)
    }
}


