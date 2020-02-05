SUMMARY = "The basic component set for container host."
DESCRIPTION = "The set of packages required for container host image."
LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
    packagegroup-container-host \
    "

ALLOW_EMPTY_${PN} = "1"

RDEPENDS_${PN} += "\
    lxc \
    agl-container-manager \
"

