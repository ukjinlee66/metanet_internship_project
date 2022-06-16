import {
    Table,
    TableBody,
    TableCell,
    TableContainer,
    TableFooter,
    TableHead,
    TablePagination,
    TableRow,
    Paper,
    Link
} from "@material-ui/core";
import React, { useState } from "react";

function Table1({ qna }) {


    const [page, setPage] = useState(0);
    const [rowsPerPage, setRowsPerPage] = useState(10);

    const handleChangePage = (event, newPage) => {
        setPage(newPage);
    };

    const handleChangeRowsPerPage = (event) => {
        setRowsPerPage(parseInt(event.target.value, 10));
        setPage(0);
    };

    const getDetail =(e)=> {
        const BASEURL = "http://localhost:3000/zipcook/postView/"
        const Number = e.value
        console.log(Number)
        const QNAURL = BASEURL + Number
        document.location.href = QNAURL
      }

    return (


        <TableContainer component={Paper}>
            <Table size="small">
                <TableHead>
                    <TableRow>
                        <TableCell>No</TableCell>
                        <TableCell align="right">종류</TableCell>
                        <TableCell align="right">제목</TableCell>
                        <TableCell align="right">내용</TableCell>
                        <TableCell align="right">날짜</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {qna
                        .slice(page * rowsPerPage, (page + 1) * rowsPerPage)
                        .map(({ reportTableNumber, reportKind, reportName, reportDetail, crDa },i) => (

                            <TableRow key={reportTableNumber}>
                                <TableCell component="th" scope="row">
                                    {page * rowsPerPage + i + 1}
                                </TableCell>
                                <TableCell align="right">{reportKind}</TableCell>
                                
                                <TableCell align="right">
                                        {reportName}
                                </TableCell>
                                <TableCell align="right">
                                        {reportDetail}
                                </TableCell>
                                <TableCell align="right">{crDa}</TableCell>
                            </TableRow>

                        ))}

                </TableBody>
                <TableFooter>
                    <TableRow>
                        <TablePagination
                            count={qna.length}
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