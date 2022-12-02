package examples

import geb.Browser
import geb.Module
import geb.Page

class ParameterizedModule extends Module {
    static content = {
        button {
            $("form", id: formId).find("input", type: "button")
        }
    }
    String formId
}

class ParameterizedModulePage extends Page {
    static content = {
        form { id -> module(new ParameterizedModule(formId: id)) }
    }
}

Browser.drive {
    to ParameterizedModulePage
    form("personal-data").button.click()
}

