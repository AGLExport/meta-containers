DESCRIPTION = "lxc bridge setup"
SECTION = "container/lxc"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD;md5=3775480a712fc46a69647678acb234cb"

inherit systemd

RDEPENDS_${PN} = " \
		iproute2 \
"

SRC_URI = " \
	file://lxc-bridge-setup \
	file://lxc-bridge-setup.service \
	"

S = "${WORKDIR}/${BPN}-${PV}"

do_install() {
	install -d ${D}/usr/libexec
	install -m 0755 ${WORKDIR}/lxc-bridge-setup ${D}/usr/libexec

	install -d ${D}/lib/systemd/system
	install -m 0644 ${WORKDIR}/lxc-bridge-setup.service ${D}/lib/systemd/system
}

FILES_${PN} += " ${systemd_unitdir} /usr/libexec/* "

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "lxc-bridge-setup.service"
