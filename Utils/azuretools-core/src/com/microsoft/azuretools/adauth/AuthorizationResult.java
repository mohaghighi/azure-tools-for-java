/*
 * Copyright (c) Microsoft Corporation
 *   <p/>
 *  All rights reserved.
 *   <p/>
 *  MIT License
 *   <p/>
 *  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 *  documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 *  the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and
 *  to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *  <p/>
 *  The above copyright notice and this permission notice shall be included in all copies or substantial portions of
 *  the Software.
 *   <p/>
 *  THE SOFTWARE IS PROVIDED *AS IS*, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
 *  THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 *  TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

package com.microsoft.azuretools.adauth;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

enum AuthorizationStatus {
    Failed,
    Success
};

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorizationResult {
    AuthorizationResult(String code) {
        this.status = AuthorizationStatus.Success;
        this.code = code;
    }

    public AuthorizationStatus getStatus() {
        return status;
    }

    AuthorizationResult(String error, String errorDescription) {
        this.status = AuthorizationStatus.Failed;
        this.error = error;
        this.errorDescription = errorDescription;
        this.errorSubcode = null;
    }

    AuthorizationResult(String error, String errorDescription, String errorSubcode) {
        this.status = AuthorizationStatus.Failed;
        this.error = error;
        this.errorDescription = errorDescription;
        this.errorSubcode = errorSubcode;
    }

    private AuthorizationStatus status;
    
    @JsonProperty("Code")
    private String code;

    @JsonProperty("Error")
    private String error;

    @JsonProperty("ErrorDescription")
    private String errorDescription;

    private String errorSubcode;

    public String getCode() {
        return code;
    }

    public String getError() {
        return error;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public String getErrorSubcode() {
        return errorSubcode;
    }

}