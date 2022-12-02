package examples

import geb.Page

// <div id="a">a</div>
class PageWithDiv extends Page {
    static content = {
        theDiv { $('div', id: 'a') }
        // theDiv(cache: false, required: false) { $("div", id: "a") }
    }
}

