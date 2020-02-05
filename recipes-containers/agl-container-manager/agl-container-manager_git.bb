SUMMARY = "AGL Container Manager (draft)"
DESCRIPTION = " AGL Container Manager for AGL Cluster "
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD;md5=3775480a712fc46a69647678acb234cb"

PV = "0.1.0+rev${SRCPV}"

DEPENDS = "jsoncpp"

SRCREV = "9a16be1be21970792a9783090010a18199f9b7c2"
SRC_URI = "git://github.com/AGLExport/agl-container-manager.git \
          "

inherit autotools pkgconfig

S = "${WORKDIR}/git"

#systemd service files
inherit systemd

SRC_URI_append = " file://agl-container-manager.service "

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "agl-container-manager.service"

do_install_append() {
#install scripts
	install -d ${D}/lxc/conf/
#	install -m 0644 ${WORKDIR}/cluster.json ${D}/lxc/conf
#	install -m 0644 ${WORKDIR}/ivi.json ${D}/lxc/conf
#	install -m 0644 ${WORKDIR}/musl.json ${D}/lxc/conf

	install -d ${D}/lib/systemd/system
	install -m 0644 ${WORKDIR}/agl-container-manager.service ${D}/lib/systemd/system
}

FILES_${PN} += " ${systemd_unitdir} /lxc/conf/* /lxc/conf "

