/**
 * Copyright (c) 2016 Zerocracy
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to read
 * the Software only. Permissions is hereby NOT GRANTED to use, copy, modify,
 * merge, publish, distribute, sublicense, and/or sell copies of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.zerocracy.crews.slack;

import com.ullink.slack.simpleslackapi.SlackSession;
import com.ullink.slack.simpleslackapi.events.SlackChannelJoined;
import com.zerocracy.jstk.Farm;
import java.io.IOException;

/**
 * Invite to the channel.
 *
 * @author Yegor Bugayenko (yegor256@gmail.com)
 * @version $Id$
 * @since 0.1
 */
final class ReInvite implements Reaction<SlackChannelJoined> {

    @Override
    public boolean react(final Farm farm, final SlackChannelJoined event,
        final SlackSession session) throws IOException {
        session.sendMessage(
            event.getSlackChannel(),
            String.join(
                " ",
                "Thanks for inviting me here. This channel will be",
                "dedicated to a single project that I will manage for you.",
                String.format(
                    "Your project ID is `%s`.",
                    event.getSlackChannel().getId()
                ),
                "When you're ready, you can start giving me instructions,",
                "always prefixing your messages with my name.",
                "If you need help, start here:",
                "http://www.0crat.com/slack.html"
            )
        );
        return true;
    }

}