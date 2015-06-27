/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2015 ForgeRock AS. All Rights Reserved
 *
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the License at
 * http://forgerock.org/license/CDDLv1.0.html
 * See the License for the specific language governing
 * permission and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL
 * Header Notice in each file and include the License file
 * at http://forgerock.org/license/CDDLv1.0.html
 * If applicable, add the following below the CDDL Header,
 * with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * Version 0.1
 * Author Jake Feasel
 */
package org.forgerock.openicf.connectors.elasticsearch

import org.identityconnectors.common.logging.Log
import groovyx.net.http.RESTClient
import static groovyx.net.http.Method.GET

def log = log as Log
def connection = customizedConnection as RESTClient


connection.request(GET) {
    uri.path = '/_cat/health'

    response.success = { resp, json ->
        /* Log something to demonstrate this script executed */
        log.info("Successfully found a " + json.size() + " node ElasticSearch cluster");
    }
}
