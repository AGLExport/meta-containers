inherit ${@bb.utils.contains('ENABLE_BINARY_ONLY_DEPLOY', '1', 'binary_only_deploy', 'binary_only_create', d)}

