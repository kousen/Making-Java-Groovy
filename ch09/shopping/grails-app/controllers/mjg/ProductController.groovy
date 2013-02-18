package mjg

import grails.converters.JSON
import grails.converters.XML

class ProductController {

    static scaffold = true

    def list() {
        def products = Product.list()
        withFormat {
            html productList: products
            xml { render products as XML }
            json { render products as JSON }
        }
    }
}
