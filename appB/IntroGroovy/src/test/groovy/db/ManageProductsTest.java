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
package db;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ManageProductsTest {
    private ManageProducts dao;

    @Before
    public void setUpDatabase() throws Exception {
        dao = new ManageProducts();
    }
    
    @Test
    public void testGetAllProducts() {
        assertEquals(3, dao.getAllProducts().size());
    }

    @Test
    public void testFindProductById() {
        Product p = dao.findProductById(1);
        assertEquals(1, p.getId());
        assertEquals("baseball", p.getName());
    }

    @Test
    public void testInsertAndDeleteProduct() {
        assertEquals(3, dao.getAllProducts().size());
        Product p = new Product(4,"soccer ball",16.99);
        dao.insertProduct(p);
        assertEquals(4, dao.getAllProducts().size());
        dao.deleteProduct(4);
        assertEquals(3, dao.getAllProducts().size());
    }

}
