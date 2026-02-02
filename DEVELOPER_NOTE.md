# Developer Notes – Forked wireguard-android

This [repository](https://github.com/atom-sdk/wireguard-android) is a fork of the official **[wireguard-android](https://github.com/WireGuard/wireguard-android)** project.  
The purpose of this fork is to introduce required enhancements while keeping the codebase as close as possible to upstream for easier maintenance and rebasing.

---

## Summary of Changes

The following updates have been applied on top of the upstream wireguard-android codebase:

### Modified Tunnel UP/DOWN signal
- Implemented a log-based detection mechanism to accurately determine when the WireGuard tunnel is truly established.
- By default, WireGuard signals the tunnel as UP immediately and performs the handshake in parallel. This can result in false-positive tunnel establishment events.
- With the new log-reading approach, the tunnel is marked UP only after a successful handshake is confirmed.
- **Note:** This behavior does not function correctly on Amazon Firestick devices because Firestick does not allow to read logs. So, the actual implementation remains same for Amazon.
  
**Internal changes include:**
Updated the log tag in `api-android.go` from `WireGuard/GoBackend/Stacktrace` to `WireGuardGoBackendLogs` to enable reliable log parsing.

### 16KB Memory Page Size Support
- Added support for **16KB memory page size**.

---

## Fork Maintenance Strategy

To ensure long-term maintainability and clean synchronization with upstream, the following workflow **must be followed**:

**Pull latest changes or Clone**
   ```bash
   git clone https://github.com/atom-sdk/wireguard-android
   git checkout master
   git checkout -b <branch-name>
   ```

When the required changes has been completed, push and create PR and merge into master.

### Upstream Compatibility Guidelines

- Do not reformat or refactor upstream code unless strictly necessary.
- Avoid changing public APIs without strong justification.
- Any upstream conflict resolution should prefer upstream behavior unless it breaks required functionality.
- Rebase regularly when upstream updates are pulled.