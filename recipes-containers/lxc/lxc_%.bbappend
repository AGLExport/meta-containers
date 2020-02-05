FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
	file://lxc-net.service \
"

do_install_append () {
	install -m 0644 ${WORKDIR}/lxc-net.service ${D}/lib/systemd/system
}

RDEPENDS_${PN} = " \
		libcap-bin \
		bridge-utils \
		dnsmasq \
		libidn \
		util-linux-mountpoint \
		util-linux-getopt \
"
