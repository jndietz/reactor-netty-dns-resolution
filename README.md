# reactor-netty-dns-resolution

This is a project intended to replicate an issue where Spring `WebClient` is unable to resolve a given DNS.  In this particular case, the application will attempt to validate a given JWT with Okta.  This typically results in an error that looks like this:

```
Caused by: java.net.UnknownHostException: failed to resolve 'dev-542348.okta.com' after 3 queries 
	at io.netty.resolver.dns.DnsResolveContext.finishResolve(DnsResolveContext.java:1046) ~[netty-resolver-dns-4.1.66.Final.jar:4.1.66.Final]
	at io.netty.resolver.dns.DnsResolveContext.tryToFinishResolve(DnsResolveContext.java:999) ~[netty-resolver-dns-4.1.66.Final.jar:4.1.66.Final]
	at io.netty.resolver.dns.DnsResolveContext.query(DnsResolveContext.java:417) ~[netty-resolver-dns-4.1.66.Final.jar:4.1.66.Final]
	at io.netty.resolver.dns.DnsResolveContext.access$600(DnsResolveContext.java:65) ~[netty-resolver-dns-4.1.66.Final.jar:4.1.66.Final]
	at io.netty.resolver.dns.DnsResolveContext$2.operationComplete(DnsResolveContext.java:466) ~[netty-resolver-dns-4.1.66.Final.jar:4.1.66.Final]
	at io.netty.util.concurrent.DefaultPromise.notifyListener0(DefaultPromise.java:578) ~[netty-common-4.1.66.Final.jar:4.1.66.Final]
	at io.netty.util.concurrent.DefaultPromise.notifyListeners0(DefaultPromise.java:571) ~[netty-common-4.1.66.Final.jar:4.1.66.Final]
	at io.netty.util.concurrent.DefaultPromise.notifyListenersNow(DefaultPromise.java:550) ~[netty-common-4.1.66.Final.jar:4.1.66.Final]
	at io.netty.util.concurrent.DefaultPromise.notifyListeners(DefaultPromise.java:491) ~[netty-common-4.1.66.Final.jar:4.1.66.Final]
	at io.netty.util.concurrent.DefaultPromise.setValue0(DefaultPromise.java:616) ~[netty-common-4.1.66.Final.jar:4.1.66.Final]
	at io.netty.util.concurrent.DefaultPromise.setFailure0(DefaultPromise.java:609) ~[netty-common-4.1.66.Final.jar:4.1.66.Final]
	at io.netty.util.concurrent.DefaultPromise.tryFailure(DefaultPromise.java:117) ~[netty-common-4.1.66.Final.jar:4.1.66.Final]
	at io.netty.resolver.dns.DnsQueryContext.tryFailure(DnsQueryContext.java:225) ~[netty-resolver-dns-4.1.66.Final.jar:4.1.66.Final]
	at io.netty.resolver.dns.DnsQueryContext$4.run(DnsQueryContext.java:177) ~[netty-resolver-dns-4.1.66.Final.jar:4.1.66.Final]
	at io.netty.util.concurrent.PromiseTask.runTask(PromiseTask.java:98) ~[netty-common-4.1.66.Final.jar:4.1.66.Final]
	at io.netty.util.concurrent.ScheduledFutureTask.run(ScheduledFutureTask.java:170) ~[netty-common-4.1.66.Final.jar:4.1.66.Final]
	at io.netty.util.concurrent.AbstractEventExecutor.safeExecute$$$capture(AbstractEventExecutor.java:164) ~[netty-common-4.1.66.Final.jar:4.1.66.Final]
	at io.netty.util.concurrent.AbstractEventExecutor.safeExecute(AbstractEventExecutor.java) ~[netty-common-4.1.66.Final.jar:4.1.66.Final]
	at io.netty.util.concurrent.SingleThreadEventExecutor.runAllTasks(SingleThreadEventExecutor.java:469) ~[netty-common-4.1.66.Final.jar:4.1.66.Final]
	at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:500) ~[netty-transport-4.1.66.Final.jar:4.1.66.Final]
	at io.netty.util.concurrent.SingleThreadEventExecutor$4.run(SingleThreadEventExecutor.java:986) ~[netty-common-4.1.66.Final.jar:4.1.66.Final]
	at io.netty.util.internal.ThreadExecutorMap$2.run(ThreadExecutorMap.java:74) ~[netty-common-4.1.66.Final.jar:4.1.66.Final]
	at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30) ~[netty-common-4.1.66.Final.jar:4.1.66.Final]
	at java.base/java.lang.Thread.run(Thread.java:834) ~[na:na]
Caused by: io.netty.resolver.dns.DnsNameResolverTimeoutException: [/205.171.3.25:53] query via UDP timed out after 5000 milliseconds (no stack trace available)
```

# Running

Clone the project, and run `gradlew bootRun`.  The application is running when you see a log entry that states

```
2021-07-26 13:59:22.091  INFO 8144 --- [           main] com.dietz.Application                    : Started Application in 2.622 seconds (JVM running for 7.08)
```

# Postman Collection

Import the collection into Postman, and request a new access token.  Use the values from the Okta Authentication section.  Use the returned JWT in an `Authorization` header prefixed with `Bearer`.  For example `Authorization: Bearer <token value>`.

# Okta Authentication

**User name:**  test@test.com

**Password:**   B0bbyJ0n3z!!