do_create_binary_archive () {
    mkdir -p ${TOPDIR}/binary-cache/
    rm -f ${TOPDIR}/binary-cache/${PN}_${PV}.tar.bz2
    tar -cvjf ${TOPDIR}/binary-cache/${PN}_${PV}.tar.bz2 -C ${D} .
}

addtask do_create_binary_archive after do_install before do_package