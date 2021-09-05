LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/src/drm-lease-manager;protocol=https;branch=master \
           file://drm-lease-manager.service \
           file://run-ptest \
           "

PV = "0.1+git${SRCPV}"
SRCREV = "43feb8701361e43ef43460ae16b3837e97b174ed"

S = "${WORKDIR}/git"

inherit meson
inherit systemd
inherit ptest

DEPENDS = "libdrm libcheck fff"

do_install_append() {
    install -d ${D}/${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/drm-lease-manager.service ${D}/${systemd_unitdir}/system
    rm -rf ${D}/${localstatedir}
}

SYSTEMD_SERVICE_${PN} = "drm-lease-manager.service"

EXTRA_OEMESON += "${@bb.utils.contains('PTEST_ENABLED', '1', '-Denable-tests=true', '', d)}"
RDEPENDS_${PN}-ptest = "libcheck"

do_install_ptest() {
    install ${B}/libdlmclient/test/libdlmclient-test ${D}${PTEST_PATH}
    install ${B}/drm-lease-manager/test/lease-server-test ${D}${PTEST_PATH}
    install ${B}/drm-lease-manager/test/lease-manager-test ${D}${PTEST_PATH}
}

PACKAGES =+ "libdlmclient"
FILES_libdlmclient = "${libdir}/libdlmclient${SOLIBS}"
