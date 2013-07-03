/* ===================================================
 * Copyright 2012 Kousen IT, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ========================================================== */
package mjg

import org.springframework.dao.DataIntegrityViolationException

class CastleController {
    def geocoderService

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [castleInstanceList: Castle.list(params), castleInstanceTotal: Castle.count(),
         mapColumns:geocoderService.columns, mapData:geocoderService.markers]
    }

    def create() {
        [castleInstance: new Castle(params)]
    }

    def save() {
        def castleInstance = new Castle(params)
        geocoderService?.fillInLatLng(castleInstance)
        if (!castleInstance.save(flush: true)) {
            render(view: "create", model: [castleInstance: castleInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'castle.label', default: 'Castle'), castleInstance.id])
        redirect(action: "show", id: castleInstance.id)
    }

    def show() {
        def castleInstance = Castle.get(params.id)
        if (!castleInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'castle.label', default: 'Castle'), params.id])
            redirect(action: "list")
            return
        }

        [castleInstance: castleInstance]
    }

    def edit() {
        def castleInstance = Castle.get(params.id)
        if (!castleInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'castle.label', default: 'Castle'), params.id])
            redirect(action: "list")
            return
        }

        [castleInstance: castleInstance]
    }

    def update() {
        def castleInstance = Castle.get(params.id)
        if (!castleInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'castle.label', default: 'Castle'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (castleInstance.version > version) {
                castleInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'castle.label', default: 'Castle')] as Object[],
                          "Another user has updated this Castle while you were editing")
                render(view: "edit", model: [castleInstance: castleInstance])
                return
            }
        }

        castleInstance.properties = params
        geocoderService?.fillInLatLng(castleInstance)
        if (!castleInstance.save(flush: true)) {
            render(view: "edit", model: [castleInstance: castleInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'castle.label', default: 'Castle'), castleInstance.id])
        redirect(action: "show", id: castleInstance.id)
    }

    def delete() {
        def castleInstance = Castle.get(params.id)
        if (!castleInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'castle.label', default: 'Castle'), params.id])
            redirect(action: "list")
            return
        }

        try {
            castleInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'castle.label', default: 'Castle'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'castle.label', default: 'Castle'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
