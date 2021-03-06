package io.playpen.core.coordinator;


import io.netty.channel.Channel;
import io.playpen.core.networking.TransactionInfo;
import io.playpen.core.p3.PackageManager;
import io.playpen.core.plugin.PluginManager;
import io.playpen.core.protocol.Commands;
import io.playpen.core.protocol.Protocol;

import java.util.UUID;
import java.util.concurrent.ScheduledExecutorService;

public abstract class PlayPen {
    private static PlayPen instance = null;

    public static PlayPen get() {
        return instance;
    }

    // do not call except from Bootstrap
    public static void reset() {
        instance = null;
    }

    public PlayPen() {
        instance = this;
    }

    public abstract String getServerId();

    public abstract CoordinatorMode getCoordinatorMode();

    public abstract PackageManager getPackageManager();

    public abstract PluginManager getPluginManager();

    public abstract ScheduledExecutorService getScheduler();

    public String generateId() {
        return getServerId() + "-" + UUID.randomUUID().toString();
    }

    public abstract boolean send(Protocol.Transaction message, String target);

    public abstract boolean receive(Protocol.AuthenticatedMessage auth, Channel from);

    public abstract boolean process(Commands.BaseCommand command, TransactionInfo info, String from);

    public abstract void onVMShutdown();
}
