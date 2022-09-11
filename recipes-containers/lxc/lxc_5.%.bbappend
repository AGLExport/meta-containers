PACKAGECONFIG = " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'systemd', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'selinux', 'selinux', '', d)} \
"

SYSTEMD_AUTO_ENABLE_${PN} = "disable"
SYSTEMD_AUTO_ENABLE_${PN}-networking = "disable"

RDEPENDS_${PN} = ""

