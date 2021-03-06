package net.minecraft.server;

import java.util.List;
import java.util.regex.Matcher;

public class CommandPardonIP extends CommandAbstract {

    public CommandPardonIP() {}

    public String b() {
        return "pardon-ip";
    }

    public boolean b(ICommandListener icommandlistener) {
        return MinecraftServer.getServer().getServerConfigurationManager().getIPBans().isEnabled() && super.b(icommandlistener);
    }

    public String a(ICommandListener icommandlistener) {
        return icommandlistener.a("commands.unbanip.usage", new Object[0]);
    }

    public void b(ICommandListener icommandlistener, String[] astring) {
        if (astring.length == 1 && astring[0].length() > 1) {
            Matcher matcher = CommandBanIp.a.matcher(astring[0]);

            if (matcher.matches()) {
                MinecraftServer.getServer().getServerConfigurationManager().getIPBans().remove(astring[0]);
                a(icommandlistener, "commands.unbanip.success", new Object[] { astring[0]});
            } else {
                throw new ExceptionInvalidSyntax("commands.unbanip.invalid", new Object[0]);
            }
        } else {
            throw new ExceptionUsage("commands.unbanip.usage", new Object[0]);
        }
    }

    public List a(ICommandListener icommandlistener, String[] astring) {
        return astring.length == 1 ? a(astring, MinecraftServer.getServer().getServerConfigurationManager().getIPBans().getEntries().keySet()) : null;
    }
}
