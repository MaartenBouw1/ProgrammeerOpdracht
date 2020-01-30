package opdracht;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {

    public Set printDuplicate(Set referenceNumber) {
        Set returnSet = new HashSet();
        Set set = new HashSet();
        for (Object reference : referenceNumber) {
            if (!set.add(reference)) {
                returnSet.add(reference);
            }
        }

        System.out.println("returnSet" + returnSet);
        System.out.println("set" + set);

        return returnSet;
    }
}
