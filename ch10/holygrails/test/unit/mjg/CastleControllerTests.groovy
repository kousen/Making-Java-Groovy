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

import org.junit.Before

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import groovy.mock.interceptor.StubFor

@TestFor(CastleController)
@Mock(Castle)
class CastleControllerTests {
    
    @Before
    void setUp() {
//        def gs = new StubFor(GeocoderService)
//        gs.demand.fillInLatLng { castle -> castle }
//        gs.use {
//            controller.geocoderService = gs
//        }
//        controller.geocoderService = new GeocoderService()
    }


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
      params['name'] = 'Camelot'
      params['city'] = 'Marlborough'
      params['state'] = 'CT'
    }

    void testIndex() {
        controller.index()
        assert "/castle/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.castleInstanceList.size() == 0
        assert model.castleInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.castleInstance != null
    }

    void testSave() {
        controller.save()

        assert model.castleInstance != null
        assert view == '/castle/create'

        response.reset()

        populateValidParams(params)
        println params
        controller.save()

        assert response.redirectedUrl == '/castle/show/1'
        assert controller.flash.message != null
        assert Castle.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/castle/list'


        populateValidParams(params)
        def castle = new Castle(params)

        assert castle.save() != null

        params.id = castle.id

        def model = controller.show()

        assert model.castleInstance == castle
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/castle/list'


        populateValidParams(params)
        def castle = new Castle(params)

        assert castle.save() != null

        params.id = castle.id

        def model = controller.edit()

        assert model.castleInstance == castle
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/castle/list'

        response.reset()


        populateValidParams(params)
        def castle = new Castle(params)

        assert castle.save() != null

        // test invalid parameters in update
        params.id = castle.id
        //TODO: add invalid values to params object
        params.name = ''
        params.city = null
        params.state = ''

        controller.update()

        assert view == "/castle/edit"
        assert model.castleInstance != null

        castle.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/castle/show/$castle.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        castle.clearErrors()

        populateValidParams(params)
        params.id = castle.id
        params.version = -1
        controller.update()

        assert view == "/castle/edit"
        assert model.castleInstance != null
        assert model.castleInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/castle/list'

        response.reset()

        populateValidParams(params)
        def castle = new Castle(params)

        assert castle.save() != null
        assert Castle.count() == 1

        params.id = castle.id

        controller.delete()

        assert Castle.count() == 0
        assert Castle.get(castle.id) == null
        assert response.redirectedUrl == '/castle/list'
    }
}
