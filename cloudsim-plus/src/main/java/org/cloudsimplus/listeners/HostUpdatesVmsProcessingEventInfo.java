/**
 * CloudSim Plus: A highly-extensible and easier-to-use Framework for Modeling and Simulation of Cloud Computing Infrastructures and Services.
 * http://cloudsimplus.org
 *
 *     Copyright (C) 2015-2016  Universidade da Beira Interior (UBI, Portugal) and the Instituto Federal de Educação Ciência e Tecnologia do Tocantins (IFTO, Brazil).
 *
 *     This file is part of CloudSim Plus.
 *
 *     CloudSim Plus is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     CloudSim Plus is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with CloudSim Plus. If not, see <http://www.gnu.org/licenses/>.
 */
package org.cloudsimplus.listeners;

import org.cloudbus.cloudsim.hosts.Host;

/**
 * An {@link EventInfo} class that stores data to be passed
 * to {@link EventListener} objects that are registered to be notified
 * when a Host updates the processing of all its VMs.
 *
 * @see Host#getOnUpdateVmsProcessingListener()
 * @author Manoel Campos da Silva Filho
 * @since CloudSim Plus 1.0
 */
public class HostUpdatesVmsProcessingEventInfo extends HostEventInfoSimple  {
    private double completionTimeOfNextFinishingCloudlet;

    public HostUpdatesVmsProcessingEventInfo(double time, Host host) {
        super(time, host);
    }

    /**
     * @return the completion time of one next finishing cloudlet
     */
    public double getCompletionTimeOfNextFinishingCloudlet() {
        return completionTimeOfNextFinishingCloudlet;
    }

    /**
     * Sets the completion time of one next finishing cloudlet
     * @param completionTimeOfNextFinishingCloudlet
     */
    public void setCompletionTimeOfNextFinishingCloudlet(double completionTimeOfNextFinishingCloudlet) {
        this.completionTimeOfNextFinishingCloudlet = completionTimeOfNextFinishingCloudlet;
    }


}