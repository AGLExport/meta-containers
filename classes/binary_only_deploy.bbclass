do_fetch[noexec] = "1"
do_unpack[noexec] = "1"
do_patch[noexec] = "1"
do_populate_lic[noexec] = "1"
do_configure[noexec] = "1"
do_compile[noexec] = "1"
do_install[noexec] = "1"

do_deploy_binary_archive () {
    install -d ${D}
    tar --no-same-owner -xvjf ${TOPDIR}/binary-cache/${PN}_${PV}.tar.bz2 -C ${D} 
}

addtask do_deploy_binary_archive after do_compile before do_install

