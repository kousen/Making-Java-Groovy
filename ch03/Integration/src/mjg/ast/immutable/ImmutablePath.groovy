package mjg.ast.immutable

import java.util.List;
import groovy.transform.Immutable

@Immutable
class ImmutablePath {
    List<ImmutableLine> segments = []
}
