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
import org.identityconnectors.framework.common.objects.ObjectClass
import org.identityconnectors.framework.common.objects.Uid
import org.identityconnectors.framework.common.exceptions.ConnectorException
import org.identityconnectors.framework.common.objects.Attribute
import org.identityconnectors.framework.common.objects.AttributesAccessor
import org.identityconnectors.framework.common.objects.ObjectClass
import org.identityconnectors.framework.common.objects.OperationOptions

/**
 * Built-in accessible objects
 **/

// OperationType is UPDATE for this script
def operation = operation as OperationType

// The configuration class created specifically for this connector
def configuration = configuration as elasticsearchConfiguration

// Default logging facility
def log = log as Log

// Set of attributes describing the object to be updated
def updateAttributes = new AttributesAccessor(attributes as Set<Attribute>)

// The Uid of the object to be updated
def uid = id as Uid

// The objectClass of the object to be updated, e.g. ACCOUNT or GROUP
def objectClass = objectClass as ObjectClass

/**
 * Script action - Customizable
 *
 * Update an object in the external source.  Connectors that do not support this should
 * throw an UnsupportedOperationException.
 *
 * This script should return the Uid of the updated object
 **/

/* Log something to demonstrate this script executed */
log.info("Create script, operation = " + operation.toString());

switch (operation) {
    case OperationType.UPDATE:
        switch (objectClass) {
            
            default:
                break
        }
        return uid
    case OperationType.ADD_ATTRIBUTE_VALUES:
        throw new UnsupportedOperationException(operation.name() + " operation of type:" +
                objectClass.objectClassValue + " is not supported.")
    case OperationType.REMOVE_ATTRIBUTE_VALUES:
        throw new UnsupportedOperationException(operation.name() + " operation of type:" +
                objectClass.objectClassValue + " is not supported.")
    default:
        throw new ConnectorException("UpdateScript can not handle operation:" + operation.name())
}
