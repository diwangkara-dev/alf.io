/**
 * This file is part of alf.io.
 *
 * alf.io is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * alf.io is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with alf.io.  If not, see <http://www.gnu.org/licenses/>.
 */
package alfio.extension.support;

import alfio.extension.exception.OutOfBoundariesException;
import org.mozilla.javascript.NativeJavaMap;
import org.mozilla.javascript.Scriptable;
import java.util.Map;

public class SandboxNativeJavaMap extends NativeJavaMap {

    private final Map<Object, Object> map;

    public SandboxNativeJavaMap(Scriptable scope, Object map) {
        super(scope, map);
        this.map = (Map<Object, Object>) map;
    }

    @Override
    public Object get(String name, Scriptable start) {
        if (name.equals("getClass") && !map.containsKey(name)){
            throw new OutOfBoundariesException("Out of boundaries class use.");
        }

        return super.get(name, start);
    }
}
