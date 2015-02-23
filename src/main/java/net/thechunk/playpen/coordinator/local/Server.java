package net.thechunk.playpen.coordinator.local;

import lombok.Data;
import net.thechunk.playpen.p3.P3Package;
import net.thechunk.playpen.utils.process.XProcess;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class Server {
    private P3Package p3;

    private String uuid;

    private String name;

    private Map<String, String> properties = new ConcurrentHashMap<>();

    private String localPath;

    private XProcess process;

    private boolean freezeOnShutdown = false;
}
