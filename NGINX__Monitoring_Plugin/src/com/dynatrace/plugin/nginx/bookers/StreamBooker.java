package com.dynatrace.plugin.nginx.bookers;

import java.util.Collection;

import org.json.JSONException;

import com.dynatrace.diagnostics.pdk.MonitorEnvironment;
import com.dynatrace.diagnostics.pdk.MonitorMeasure;
import com.dynatrace.plugin.nginx.calculator.StreamCalculator;
import com.dynatrace.plugin.nginx.dto.stream.Stream;
import com.dynatrace.plugin.nginx.dto.stream.StreamServerDTO;
import com.dynatrace.plugin.nginx.dto.stream.StreamServerZoneDTO;
import com.dynatrace.plugin.nginx.parsers.stream.StreamParser;
import com.dynatrace.plugin.nginx.utils.ServerMatcher;

public class StreamBooker extends Booker {
	//Server Zones
	public static final String MSR_SZ_PROCESSING = "Server Zones Processing";
	public static final String MSR_SZ_CONNECTIONS = "Server Zones Connections";
	public static final String MSR_SZ_CONNECTIONS_RATE = "Server Zones Connections Rate";
	public static final String MSR_SZ_RECEIVED = "Server Zones Received";
	public static final String MSR_SZ_RECEIVED_RATE = "Server Zones Received Rate";
	public static final String MSR_SZ_SENT = "Server Zones Sent";
	public static final String MSR_SZ_SEND_RATE = "Server Zones Send Rate";
	//Upstreams
	public static final String MSR_US_BACKUP = "Upstreams Backup";
	public static final String MSR_US_WEIGHT = "Upstreams Weight";
	public static final String MSR_US_STATE = "Upstreams State";
	public static final String MSR_US_ACTIVE = "Upstreams Active";
	public static final String MSR_US_TOTAL_ACTIVE = "Upstreams Total Active";
	public static final String MSR_US_MAXCONNS = "Upstreams Max Connections";
	public static final String MSR_US_CONNECTIONS  = "Upstreams Connections";
	public static final String MSR_US_CONNECTIONS_RATE = "Upstreams Connections Rate";
	public static final String MSR_US_CONNECT_TIME = "Upstreams Connect Time";
	public static final String MSR_US_FIRST_BYTE_TIME = "Upstreams First Byte Time";
	public static final String MSR_US_RESPONSE_TIME = "Upstreams Response Time";
	public static final String MSR_US_SENT = "Upstreams Sent";
	public static final String MSR_US_SENT_RATE = "Upstreams Sent Rate";
	public static final String MSR_US_RECEIVED = "Upstreams Received";
	public static final String MSR_US_RECEIVED_RATE = "Upstreams Received Rate";
	public static final String MSR_US_FAILS = "Upstreams Fails";
	public static final String MSR_US_FAILS_RATE = "Upstreams Fails Rate";
	public static final String MSR_US_UNAVAILABLE = "Upstreams Unavailable";
	public static final String MSR_US_UNAVAILABLE_RATE = "Upstreams Unavailable Rate";
	public static final String MSR_US_TOTAL_HEALTH_CHECKS = "Upstreams Total Health Checks";
	public static final String MSR_US_TOTAL_HEALTH_CHECKS_RATE = "Upstreams Total Health Checks Rate";
	public static final String MSR_US_FAILED_HEALTH_CHECKS = "Upstreams Failed Health Checks";
	public static final String MSR_US_FAILED_HEALTH_CHECKS_RATE = "Upstreams Failed Health Checks Rate";
	public static final String MSR_US_UNHEALTHY_HEALTH_CHECKS = "Upstreams Unhealthy Health Checks";
	public static final String MSR_US_UNHEALTHY_HEALTH_CHECKS_RATE = "Upstreams Unhealthy Health Checks Rate";
	public static final String MSR_US_LAST_HEALTH_CHECK_PASSED = "Upstreams Last Health Check Passed";
	public static final String MSR_US_DOWNSTART = "Upstreams Downstart";
	public static final String MSR_US_DOWNTIME = "Upstreams Downtime";
	public static final String MSR_US_SELECTED = "Upstreams Selected";

	public static void book(Stream stream, MonitorEnvironment env, StreamCalculator calculator) throws JSONException {
		Collection<MonitorMeasure> sZProcessingM = env.getMonitorMeasures(StreamParser.GROUP, MSR_SZ_PROCESSING);
		Collection<MonitorMeasure> sZConnectionsM = env.getMonitorMeasures(StreamParser.GROUP, MSR_SZ_CONNECTIONS);
		Collection<MonitorMeasure> sZConnectionsRateM = env.getMonitorMeasures(StreamParser.GROUP, MSR_SZ_CONNECTIONS_RATE);
		Collection<MonitorMeasure> sZReceivedM = env.getMonitorMeasures(StreamParser.GROUP, MSR_SZ_RECEIVED);
		Collection<MonitorMeasure> sZReceivedRateM = env.getMonitorMeasures(StreamParser.GROUP, MSR_SZ_RECEIVED_RATE);
		Collection<MonitorMeasure> sZSentM = env.getMonitorMeasures(StreamParser.GROUP, MSR_SZ_SENT);
		Collection<MonitorMeasure> sZSentRateM = env.getMonitorMeasures(StreamParser.GROUP, MSR_SZ_SEND_RATE);

		Collection<MonitorMeasure> uSBackupM = env.getMonitorMeasures(StreamParser.GROUP, MSR_US_BACKUP);
		Collection<MonitorMeasure> uSWeightM = env.getMonitorMeasures(StreamParser.GROUP, MSR_US_WEIGHT);
		Collection<MonitorMeasure> uSStateM = env.getMonitorMeasures(StreamParser.GROUP, MSR_US_STATE);
		Collection<MonitorMeasure> uSActiveM = env.getMonitorMeasures(StreamParser.GROUP, MSR_US_ACTIVE);
		Collection<MonitorMeasure> uSTotalActiveM = env.getMonitorMeasures(StreamParser.GROUP, MSR_US_TOTAL_ACTIVE);
		Collection<MonitorMeasure> uSMaxConnsM = env.getMonitorMeasures(StreamParser.GROUP, MSR_US_MAXCONNS);
		Collection<MonitorMeasure> uSConnectionsM = env.getMonitorMeasures(StreamParser.GROUP, MSR_US_CONNECTIONS);
		Collection<MonitorMeasure> uSConnectionsRateM = env.getMonitorMeasures(StreamParser.GROUP, MSR_US_CONNECTIONS_RATE);
		Collection<MonitorMeasure> uSConnectTimeM = env.getMonitorMeasures(StreamParser.GROUP, MSR_US_CONNECT_TIME);
		Collection<MonitorMeasure> uSFirstByteTimeM = env.getMonitorMeasures(StreamParser.GROUP, MSR_US_FIRST_BYTE_TIME);
		Collection<MonitorMeasure> uSResponseTimeM = env.getMonitorMeasures(StreamParser.GROUP, MSR_US_RESPONSE_TIME);
		Collection<MonitorMeasure> uSSentM = env.getMonitorMeasures(StreamParser.GROUP, MSR_US_SENT);
		Collection<MonitorMeasure> uSSentRateM = env.getMonitorMeasures(StreamParser.GROUP, MSR_US_SENT_RATE);
		Collection<MonitorMeasure> uSReceivedM = env.getMonitorMeasures(StreamParser.GROUP, MSR_US_RECEIVED);
		Collection<MonitorMeasure> uSReceivedRateM = env.getMonitorMeasures(StreamParser.GROUP, MSR_US_RECEIVED_RATE);
		Collection<MonitorMeasure> uSFailsM = env.getMonitorMeasures(StreamParser.GROUP, MSR_US_FAILS);
		Collection<MonitorMeasure> uSFailsRateM = env.getMonitorMeasures(StreamParser.GROUP, MSR_US_FAILS_RATE);
		Collection<MonitorMeasure> uSUnavailableM = env.getMonitorMeasures(StreamParser.GROUP, MSR_US_UNAVAILABLE);
		Collection<MonitorMeasure> uSUnavailableRateM = env.getMonitorMeasures(StreamParser.GROUP, MSR_US_UNAVAILABLE_RATE);
		Collection<MonitorMeasure> uSTotalHealthChecksM = env.getMonitorMeasures(StreamParser.GROUP, MSR_US_TOTAL_HEALTH_CHECKS);
		Collection<MonitorMeasure> uSTotalHealthChecksRateM = env.getMonitorMeasures(StreamParser.GROUP, MSR_US_TOTAL_HEALTH_CHECKS_RATE);
		Collection<MonitorMeasure> uSFailedHealthChecksM = env.getMonitorMeasures(StreamParser.GROUP, MSR_US_FAILED_HEALTH_CHECKS);
		Collection<MonitorMeasure> uSFailedHealthChecksRateM = env.getMonitorMeasures(StreamParser.GROUP, MSR_US_FAILED_HEALTH_CHECKS_RATE);
		Collection<MonitorMeasure> uSUnhealthyHealthChecksM = env.getMonitorMeasures(StreamParser.GROUP, MSR_US_UNHEALTHY_HEALTH_CHECKS);
		Collection<MonitorMeasure> uSUnhealthyHealthChecksRateM = env.getMonitorMeasures(StreamParser.GROUP, MSR_US_UNHEALTHY_HEALTH_CHECKS_RATE);
		Collection<MonitorMeasure> uSLastHealthCheckPassedM = env.getMonitorMeasures(StreamParser.GROUP, MSR_US_LAST_HEALTH_CHECK_PASSED);
		Collection<MonitorMeasure> uSDownstartM = env.getMonitorMeasures(StreamParser.GROUP, MSR_US_DOWNSTART);
		Collection<MonitorMeasure> uSDowntimeM = env.getMonitorMeasures(StreamParser.GROUP, MSR_US_DOWNTIME);
		Collection<MonitorMeasure> uSSelectedM = env.getMonitorMeasures(StreamParser.GROUP, MSR_US_SELECTED);

		for (StreamServerZoneDTO s : stream.getServerZones()) {
			String dynamicKey = "Server Zone";

			setDynamicMeasure(env, sZProcessingM, dynamicKey, s.getServerZoneName(), s.getProcessing());
			setDynamicMeasure(env, sZConnectionsM, dynamicKey, s.getServerZoneName(), s.getConnections());
			setDynamicMeasure(env, sZConnectionsRateM, dynamicKey, s.getServerZoneName(), calculator.getServerZoneConnectionsRate().get(s.getServerZoneName()));
			setDynamicMeasure(env, sZReceivedM, dynamicKey, s.getServerZoneName(), s.getReceived());
			setDynamicMeasure(env, sZReceivedRateM, dynamicKey, s.getServerZoneName(), calculator.getServerZoneReceivedRate().get(s.getServerZoneName()));
			setDynamicMeasure(env, sZSentM, dynamicKey, s.getServerZoneName(), s.getSent());
			setDynamicMeasure(env, sZSentRateM, dynamicKey, s.getServerZoneName(), calculator.getServerZoneSentRate().get(s.getServerZoneName()));
		}

		for(String serverGroupName : stream.getUpstreams().get().keySet()) {
			for (StreamServerDTO s : stream.getUpstreams().get().get(serverGroupName)) {
				String dynamicValue = s.getServer();

				Double StateTmp = s.getState().toDouble();
				Double ActiveTmp = s.getActive();
				Double ConnectionsTmp = s.getConnections();
				Double ConnectionsRateTmp = calculator.getUpstreamsConnectionsRate().get(serverGroupName, s.getServer());
				Double SentTmp = s.getSent();
				Double SentRateTmp = calculator.getUpstreamsSentRate().get(serverGroupName, s.getServer());
				Double ReceivedTmp = s.getReceived();
				Double ReceivedRateTmp = calculator.getUpstreamsReceivedRate().get(serverGroupName, s.getServer());
				Double FailsTmp = s.getFails();
				Double FailsRateTmp = calculator.getUpstreamsFailsRate().get(serverGroupName, s.getServer());
				Double UnavailTmp = s.getUnavail();
				Double UnavailRateTmp = calculator.getUpstreamsUnavailRate().get(serverGroupName, s.getServer());
				Double HealthChecksTotalTmp = s.getHealthChecksTotal();
				Double HealthChecksTotalRateTmp = calculator.getUpstreamsHealthChecksRate().get(serverGroupName, s.getServer());
				Double HealthChecksFailsTmp = s.getHealthChecksFails();
				Double HealthChecksFailsRateTmp = calculator.getUpstreamsHealthChecksFailedRate().get(serverGroupName, s.getServer());
				Double HealthChecksUnhealthyTmp = s.getHealthChecksUnhealthy();
				Double HealthChecksUnhealthyRateTmp = calculator.getUpstreamsHealthChecksUnhealthyRate().get(serverGroupName, s.getServer());
				Double DowntimeTmp = s.getDowntime();
				Double DownstartTmp = s.getDownstart();
				Double SelectedTmp = s.getSelected();

				if (ServerMatcher.Match(s.getServer(), env.getConfigString("StreamFilter"))) {

					setDynamicMeasure(env, uSBackupM, serverGroupName, dynamicValue, (double) (s.getBackup() ? 1 : 0));
					setDynamicMeasure(env, uSWeightM, serverGroupName, dynamicValue, s.getWeight());
					setDynamicMeasure(env, uSStateM, serverGroupName, dynamicValue, StateTmp);
					setDynamicMeasure(env, uSActiveM, serverGroupName, dynamicValue, ActiveTmp);
					if (s.getMaxConns() != null) {
						setDynamicMeasure(env, uSMaxConnsM, serverGroupName, dynamicValue, s.getMaxConns());
					}
					setDynamicMeasure(env, uSConnectionsM, serverGroupName, dynamicValue, ConnectionsTmp);
					setDynamicMeasure(env, uSConnectionsRateM, serverGroupName, dynamicValue, ConnectionsRateTmp);
					if (s.getConnectTime() != null) {
						setDynamicMeasure(env, uSConnectTimeM, serverGroupName, dynamicValue, s.getConnectTime());
					}
					if (s.getFirstByteTime() != null) {
						setDynamicMeasure(env, uSFirstByteTimeM, serverGroupName, dynamicValue, s.getFirstByteTime());
					}
					if (s.getResponseTime() != null) {
						setDynamicMeasure(env, uSResponseTimeM, serverGroupName, dynamicValue, s.getResponseTime());
					}
					setDynamicMeasure(env, uSSentM, serverGroupName, dynamicValue, SentTmp);
					setDynamicMeasure(env, uSSentRateM, serverGroupName, dynamicValue, SentRateTmp);
					setDynamicMeasure(env, uSReceivedM, serverGroupName, dynamicValue, ReceivedTmp);
					setDynamicMeasure(env, uSReceivedRateM, serverGroupName, dynamicValue, ReceivedRateTmp);
					setDynamicMeasure(env, uSFailsM, serverGroupName, dynamicValue, FailsTmp);
					setDynamicMeasure(env, uSFailsRateM, serverGroupName, dynamicValue, FailsRateTmp);
					setDynamicMeasure(env, uSUnavailableM, serverGroupName, dynamicValue, UnavailTmp);
					setDynamicMeasure(env, uSUnavailableRateM, serverGroupName, dynamicValue, UnavailRateTmp);
					setDynamicMeasure(env, uSTotalHealthChecksM, serverGroupName, dynamicValue, HealthChecksTotalTmp);
					setDynamicMeasure(env, uSTotalHealthChecksRateM, serverGroupName, dynamicValue, HealthChecksTotalRateTmp);
					setDynamicMeasure(env, uSFailedHealthChecksM, serverGroupName, dynamicValue, HealthChecksFailsTmp);
					setDynamicMeasure(env, uSFailedHealthChecksRateM, serverGroupName, dynamicValue, HealthChecksFailsRateTmp);
					setDynamicMeasure(env, uSUnhealthyHealthChecksM, serverGroupName, dynamicValue, HealthChecksUnhealthyTmp);
					setDynamicMeasure(env, uSUnhealthyHealthChecksRateM, serverGroupName, dynamicValue, HealthChecksUnhealthyRateTmp);
					if (s.getHealthChecksLastPassed() != null) {
						setDynamicMeasure(env, uSLastHealthCheckPassedM, serverGroupName, dynamicValue, (double) (s.getHealthChecksLastPassed() ? 1 : 0));
					}
					setDynamicMeasure(env, uSDowntimeM, serverGroupName, dynamicValue, DowntimeTmp);
					setDynamicMeasure(env, uSDownstartM, serverGroupName, dynamicValue, DownstartTmp);
					setDynamicMeasure(env, uSSelectedM, serverGroupName, dynamicValue, SelectedTmp);
				}
			}

			String dynamicKey = "Upstream name";

			setDynamicMeasure(env, uSConnectionsM, dynamicKey, serverGroupName, calculator.getConnectionsPerUpstream().get(serverGroupName));
			setDynamicMeasure(env, uSConnectionsRateM, dynamicKey, serverGroupName, calculator.getConnectionsRatePerUpstream().get(serverGroupName));
			setDynamicMeasure(env, uSSentM, dynamicKey, serverGroupName, calculator.getSentPerUpstream().get(serverGroupName));
			setDynamicMeasure(env, uSSentRateM, dynamicKey, serverGroupName, calculator.getSentRatePerUpstream().get(serverGroupName));
			setDynamicMeasure(env, uSReceivedM, dynamicKey, serverGroupName, calculator.getReceivedPerUpstream().get(serverGroupName));
			setDynamicMeasure(env, uSReceivedRateM, dynamicKey, serverGroupName, calculator.getReceivedRatePerUpstream().get(serverGroupName));
			setDynamicMeasure(env, uSFailsM, dynamicKey, serverGroupName, calculator.getFailsPerUpstream().get(serverGroupName));
			setDynamicMeasure(env, uSFailsRateM, dynamicKey, serverGroupName, calculator.getFailsRatePerUpstream().get(serverGroupName));
			setDynamicMeasure(env, uSUnavailableM, dynamicKey, serverGroupName, calculator.getUnavailPerUpstream().get(serverGroupName));
			setDynamicMeasure(env, uSUnavailableRateM, dynamicKey, serverGroupName, calculator.getUnavailRatePerUpstream().get(serverGroupName));
			setDynamicMeasure(env, uSTotalHealthChecksM, dynamicKey, serverGroupName, calculator.getHealthChecksTotalPerUpstream().get(serverGroupName));
			setDynamicMeasure(env, uSTotalHealthChecksRateM, dynamicKey, serverGroupName, calculator.getHealthChecksTotalRatePerUpstream().get(serverGroupName));
			setDynamicMeasure(env, uSFailedHealthChecksM, dynamicKey, serverGroupName, calculator.getHealthChecksFailedPerUpstream().get(serverGroupName));
			setDynamicMeasure(env, uSFailedHealthChecksRateM, dynamicKey, serverGroupName, calculator.getHealthChecksFailedRatePerUpstream().get(serverGroupName));
			setDynamicMeasure(env, uSUnhealthyHealthChecksM, dynamicKey, serverGroupName, calculator.getHealthChecksUnhealthyPerUpstream().get(serverGroupName));
			setDynamicMeasure(env, uSUnhealthyHealthChecksRateM, dynamicKey, serverGroupName, calculator.getHealthChecksUnhealthyRatePerUpstream().get(serverGroupName));
		}

		for (MonitorMeasure m : uSTotalActiveM) {
			m.setValue(calculator.getTotalActive());
		}
	}
}
