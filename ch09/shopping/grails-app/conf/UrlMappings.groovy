class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')

        "/product/$id?"(resource: "product")
        "/customer/$id?"(resource: "customer")
        "/order/$id"(resource: "order")
        "/orderLine/$id"(resource: "orderLine")
	}
}
