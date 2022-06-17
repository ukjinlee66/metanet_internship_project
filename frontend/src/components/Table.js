import {
    Table,
    TableBody,
    TableCell,
    TableContainer,
    TableFooter,
    TableHead,
    TablePagination,
    TableRow,
    Paper
} from "@material-ui/core";
import React, { useState } from "react";

function Table1({ users } ) {


    const [page, setPage] = useState(0);
    const [rowsPerPage, setRowsPerPage] = useState(10);

    const handleChangePage = (event, newPage) => {
        setPage(newPage);
    };

    const handleChangeRowsPerPage = (event) => {
        setRowsPerPage(parseInt(event.target.value, 10));
        setPage(0);
    };
        return (

            <TableContainer component={Paper}>
                <Table size="small">
                    <TableHead>
                        <TableRow>
                            <TableCell>No</TableCell>
                            <TableCell align="right">종류</TableCell>
                            <TableCell align="right">금액</TableCell>
                            <TableCell align="right">날짜</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {users
                            .slice(page * rowsPerPage, (page + 1) * rowsPerPage)
                            .map(({ number , kind , point , date }, i) => (
                                <TableRow key={number}>
                                    <TableCell component="th" scope="row">
                                        {page * rowsPerPage + i + 1}
                                    </TableCell>
                                    <TableCell align="right">{kind}</TableCell>
                                    <TableCell align="right">{point}</TableCell>
                                    <TableCell align="right">{date}</TableCell>
                                </TableRow>
                            ))}
                    </TableBody>
                    <TableFooter>
                        <TableRow>
                            <TablePagination
                                count={users.length}
                                page={page}
                                rowsPerPage={rowsPerPage}
                                onChangePage={handleChangePage}
                                onChangeRowsPerPage={handleChangeRowsPerPage}
                            />
                        </TableRow>
                    </TableFooter>
                </Table>
            </TableContainer>
        );
}

export default Table1;
