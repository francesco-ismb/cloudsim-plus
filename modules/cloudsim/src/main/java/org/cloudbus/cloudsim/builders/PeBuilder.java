package org.cloudbus.cloudsim.builders;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.cloudbus.cloudsim.Pe;
import org.cloudbus.cloudsim.PeSimple;
import org.cloudbus.cloudsim.provisioners.PeProvisioner;
import org.cloudbus.cloudsim.provisioners.PeProvisionerSimple;

/**
 * A Builder class to create {@link PeSimple} objects.
 * 
 * @author Manoel Campos da Silva Filho
 */
public class PeBuilder extends Builder {
    private Class<? extends PeProvisioner> defaultProvisionerClass = PeProvisionerSimple.class;

    public List<Pe> create(final int amount, final double mipsOfEachPe) {
        try {
            validateAmount(amount);
            List<Pe> peList = new ArrayList<>();
            Constructor cons =
                    defaultProvisionerClass.getConstructor(new Class[]{double.class});
            for (int i = 0; i < amount; i++) {
                peList.add(new PeSimple(i, (PeProvisioner) cons.newInstance(mipsOfEachPe)));
            }
            return peList;
        } catch (NoSuchMethodException | SecurityException ex) {
            throw new RuntimeException("It wasn't possible to instantiate a list of Pe", ex);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            throw new RuntimeException("It wasn't possible to instantiate a list of Pe", ex);
        }
    }

    public Class<? extends PeProvisioner> getDefaultProvisionerClass() {
        return defaultProvisionerClass;
    }

    public PeBuilder setDefaultProvisioner(Class<? extends PeProvisioner> defaultProvisioner) {
        this.defaultProvisionerClass = defaultProvisioner;
        return this;
    }
}