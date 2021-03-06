/*
 * Copyright 2011 Goldman Sachs.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gs.collections.impl.block.procedure.checked;

import com.gs.collections.api.block.procedure.ObjectIntProcedure;

public abstract class CheckedObjectIntProcedure<T>
        implements ObjectIntProcedure<T>
{
    private static final long serialVersionUID = 1L;

    public final void value(T object, int index)
    {
        try
        {
            this.safeValue(object, index);
        }
        catch (RuntimeException e)
        {
            throw e;
        }
        catch (Exception e)
        {
            throw new RuntimeException("Checked exception caught in Procedure", e);
        }
    }

    @SuppressWarnings("ProhibitedExceptionDeclared")
    public abstract void safeValue(T object, int index) throws Exception;
}
