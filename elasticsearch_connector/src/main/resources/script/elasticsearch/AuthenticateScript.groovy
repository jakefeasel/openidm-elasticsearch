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

import org.forgerock.openicf.connectors.elasticsearch.elasticsearchConfiguration
import org.forgerock.openicf.misc.scriptedcommon.OperationType
import org.identityconnectors.common.logging.Log
import org.identityconnectors.framework.common.exceptions.InvalidPasswordException

/**
 * Built-in accessible objects
 **/

// OperationType is AUTHENTICATION for this script
def operation = operation as OperationType

// The configuration class created specifically for this connector
def configuration = configuration as elasticsearchConfiguration

// Default logging facility
def log = log as Log

/**
 * Script action - Customizable
 *
 * Must either return an int or String convertible to a Uid object or throw an exception
 **/

def authId = null;

/* Perform an action to authenticate against the external source. If no authentication is
    required then allow authId to pass through by default. This script is required. */
authId = 1;

if (authId == null) {
    throw new InvalidPasswordException("Authentication Failed")
}

/* Log something to demonstrate this script executed */
log.info("Authenticate script, operation = " + operation.toString());

return authId
