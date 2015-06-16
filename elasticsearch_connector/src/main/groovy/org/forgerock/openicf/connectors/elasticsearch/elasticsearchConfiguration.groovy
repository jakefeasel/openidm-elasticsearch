/*
 * DO NOT REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2015 ForgeRock AS All rights reserved.
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
 */

package org.forgerock.openicf.connectors.elasticsearch

import org.codehaus.groovy.runtime.InvokerHelper
import org.forgerock.openicf.misc.scriptedcommon.ScriptedConfiguration
import org.identityconnectors.common.Assertions
import org.identityconnectors.common.StringUtil
import org.identityconnectors.common.security.GuardedString
import org.identityconnectors.framework.common.exceptions.ConfigurationException
import org.identityconnectors.framework.spi.AbstractConfiguration
import org.identityconnectors.framework.spi.ConfigurationClass
import org.identityconnectors.framework.spi.ConfigurationProperty

/**
 * Extends the {@link AbstractConfiguration} class to provide all the necessary
 * parameters to initialize the ElasticSearch Connector.
 *
 * @author Jake Feasel
 * @description Connector to the ElasticSearch REST interface
 * @version 0.1
 */
@ConfigurationClass(skipUnsupported = true)
public class elasticsearchConfiguration extends org.forgerock.openicf.connectors.scriptedrest.ScriptedRESTConfiguration {

    // Exposed configuration properties.

    

    /**
     * {@inheritDoc}
     */
    @Override
    public void validate() {
        // Add property validation here if required and throw new ConfigurationException() on failure, else:
        super.validate();
    }

    @Override
    void release() {
        synchronized (this) {
            super.release();
            // Add any required shutdown logic here
        }
    }
}
